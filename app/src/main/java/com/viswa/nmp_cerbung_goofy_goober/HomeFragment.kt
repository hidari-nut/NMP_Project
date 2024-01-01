package com.viswa.nmp_cerbung_goofy_goober

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.viswa.nmp_cerbung_goofy_goober.databinding.FragmentHomeBinding
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    var recyclerView: RecyclerView? = null
    var recyclerViewCerbung: RecyclerViewCerbung? = null
    var cerbungList = mutableListOf<Cerbung>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateList()

//        val q = Volley.newRequestQueue(activity)
//        val url = "https://ubaya.me/native/160421069/project/read_cerbungs.php"
//        var stringRequest = StringRequest(Request.Method.POST, url, Response.Listener<String>{
//            val obj = JSONObject(it)
//            if(obj.getString("result") == "OK"){
//                val data = obj.getJSONArray("data")
//
//                val sType = object : TypeToken<List<Cerbung>>() { }.type
//                cerbungList = Gson().fromJson(data.toString(), sType) as
//                        ArrayList<Cerbung>
////                Log.d("apiresult", cerbungList.toString())
//                updateList()
//            }
//        },
//            Response.ErrorListener {
//                Log.e("apiresult", it.message.toString())
//            })
//        q.add(stringRequest)

//        recyclerView = binding.recyclerViewHome
//        recyclerViewCerbung = context?.let { RecyclerViewCerbung(it, cerbungList) }
//        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 1)
//        recyclerView?.layoutManager = layoutManager
//        recyclerView?.adapter = recyclerViewCerbung
//
//        recyclerViewCerbung?.notifyDataSetChanged()

//        recyclerView = binding.recyclerViewHome
//        recyclerViewCerbung = RecyclerViewCerbung(requireActivity(), cerbungList)
//        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireActivity(), 1)
//        recyclerView?.layoutManager = layoutManager
//        recyclerView?.adapter = recyclerViewCerbung
//
//        recyclerViewCerbung?.notifyDataSetChanged(
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        updateList()
    }
    fun updateList(){
        val q = Volley.newRequestQueue(activity)
        val url = "https://ubaya.me/native/160421069/project/read_cerbungs.php"
        var stringRequest = StringRequest(Request.Method.POST, url, Response.Listener<String>{
            val obj = JSONObject(it)
            if(obj.getString("result") == "OK"){
                val data = obj.getJSONArray("data")

                val sType = object : TypeToken<List<Cerbung>>() { }.type
                cerbungList = Gson().fromJson(data.toString(), sType) as
                        ArrayList<Cerbung>
//                Log.d("apiresult", cerbungList.toString())
                recyclerView = binding.recyclerViewHome
                recyclerViewCerbung = context?.let { RecyclerViewCerbung(it, cerbungList) }
                val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 1)
                recyclerView?.layoutManager = layoutManager
                recyclerView?.adapter = recyclerViewCerbung

                recyclerViewCerbung?.notifyDataSetChanged()
            }
        },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
            })
        q.add(stringRequest)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        val CERBUNG_ID = "com.viswa.nmp_gerbung_goofy_goober.cerbungID"
    }
}