package com.viswa.nmp_cerbung_goofy_goober

object Global {
    val currentCerbung = 0

    val cerbungs = arrayOf(
        Cerbungs(R.drawable.cerbungimg,"Reincarnated as a Surabayans, I now need to deal with hot weather", "Kobo Amane", 78,
            "Hideo Gosling pemuda dari " +
                "negara Ambasing harus menerima takdirnya direinkarnasikan di Surabaya.",
            listOf(CerbungParagraph("Para1 Cerbung1", "Author 1.1"),
                CerbungParagraph("Para2 Cerbung1", "Author 1.2"))
        ),
        Cerbungs(R.drawable.cerbungimg,"The brilliant success of Redd White", "Redd White", 194,
            "Book about how Redd White easily overcome his struggle to build BLUE CORP.",
            listOf(CerbungParagraph("Para1 Cerbung2", "Author 2.1"),
                CerbungParagraph("Para2 Cerbung2", "Author 2.2"))
        ),
        Cerbungs(R.drawable.cerbungimg,"Bocchi the Guitar Hero", "Edgeworth Von Karma", 46,
            "Ryan Kojima picks up his guitar and transform into Bocchi, The Guitar Hero!",
            listOf(CerbungParagraph("Para1 Cerbung3", "Author 3.1"),
                CerbungParagraph("Para2 Cerbung3", "Author 3.2"))
        ),
        Cerbungs(R.drawable.cerbungimg,"Satria Naga Coco", "Rieno Barrack", 192,
            "Siapa sangka satria yang ini bukanlah sebuah khayalan.",
            listOf(CerbungParagraph("Para1 Cerbung4", "Author 4.1"),
                CerbungParagraph("Para2 Cerbung4", "Author 4.2"))
        ),
        Cerbungs(R.drawable.cerbungimg,"Dodo's Normal Adventure", "Hirahiki Aruku", 112,
            "Dodo and his Brother, Jio accidentally found a cheap plastic mask in Pasar Atom.",
            listOf(CerbungParagraph("Para1 Cerbung5", "Author 5.1"),
                CerbungParagraph("Para2 Cerbung5", "Author 5.2"))
        ),
        Cerbungs(R.drawable.cerbungimg, "The Great Flip: The Sugar-coated Fraud", "Sam L. Jack", 864,
            "The events of The Great Flip, the Biggest Corporate Fraud Scandal of the Silicon Valley.",
          listOf(CerbungParagraph("The day starts as usual, I wake up, brew myself some coffee, kiss my wife goodbye, " +
                  "and go off to work, as if it's a normal day. I arrive at my office, the SORA Headquarters in SF. " +
                  "Not knowing what has happened or what will happen next.",
              "Sam L. Jack"),
              CerbungParagraph("I arrived at the parking lot after a long commute, I saw lines of unmarked black cars. " +
                      "I told myself that it's probably " +
                      "the government workers working on the project we are contracted for. Then I entered the building, " +
                      "there's so many agents, FBI, the SEC? what are they doing here?." , "Norm A. Lee"),
              CerbungParagraph("Now normally, you wouldn't be seeing SEC Agents in the office unless something had happened. " +
                      "Moments later, I saw our VP, " +
                      "Mr. Alex Manning escorted out by FBI agents into one of their cars. I was walking around confused, " +
                      "until I was stopped by an FBI agent myself.", "Yuul B. Alwright")
                )
        )
    )
}