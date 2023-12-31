package com.viswa.nmp_cerbung_goofy_goober

import android.R
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.viswa.nmp_cerbung_goofy_goober.databinding.FragmentCreateCerbungBinding
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateCerbungFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateCerbungFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentCreateCerbungBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val q = Volley.newRequestQueue(activity)
        val url = "https://ubaya.me/native/160421069/project/read_genres.php"
        var stringRequest = StringRequest(
            Request.Method.POST, url, Response.Listener<String>{
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK"){
                    val data = obj.getJSONArray("data")

                    val sType = object : TypeToken<ArrayList<Genre>>() { }.type
                    var genres = Gson().fromJson(data.toString(), sType) as
                            ArrayList<Genre>

                    Global.genre = genres
//                    Log.d("genreapi", Global.genre.toString())
                    updateComboBox()
                }
            },
            Response.ErrorListener {
                Log.e("genreapi", it.message.toString())
            })
        q.add(stringRequest)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateCerbungBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener(){
            var shared: SharedPreferences? =
                this.requireActivity().getSharedPreferences("CreateCerbungsPreferences", Context.MODE_PRIVATE)
            var editor: SharedPreferences.Editor? = shared?.edit()
            if (editor != null) {
                editor.putString("cerbungTitleText", binding.titleText.text.toString())
                editor.putString("shortDescriptionText", binding.shortDescriptionText.text.toString())
                editor.putString("cerbungImageCoverURL", binding.urlCoverLayoutText.text.toString())
                editor.putString("chooseGenre", binding.chooseGenreDropDown.selectedItem.toString())
                editor.putString("genreId", (binding.chooseGenreDropDown.selectedItem as Genre).id.toString())
                editor.apply()
            }
            val intent = Intent(this.context, CreateCerbungsActivity2::class.java)
            startActivity(intent)
        }
    }

    fun updateComboBox(){
        val adapter = view?.let { ArrayAdapter(it.context, R.layout.simple_list_item_1, Global.genre) }
        if (adapter != null) {
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        }
        binding.chooseGenreDropDown.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreateCerbungFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateCerbungFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}