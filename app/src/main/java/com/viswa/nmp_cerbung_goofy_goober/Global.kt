package com.viswa.nmp_cerbung_goofy_goober

object Global {

    val cerbungs = arrayOf(
        Cerbungs("https://www.worldatlas.com/r/w1200-q80/upload/64/de/e3/shutterstock-520729021.jpg",
            "The Great Flip: The Sugar-coated Fraud", "Sam L. Jack", 864, "11/9/2023",
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
        ),
        Cerbungs("https://public.urbanasia.com/images/post/2020/10/05/1601877074-cuaca-panas-Surbaya---pixabay.jpg",
            "Reincarnated as a Surabayans, I now need to deal with hot weather", "Kobo Amane", 78, "1/1/2023",
            "Hideo Gosling pemuda dari " +
                "negara Ambasing harus menerima takdirnya direinkarnasikan di Surabaya.",
            listOf(CerbungParagraph("Para1 Cerbung1", "Author 1.1"),
                CerbungParagraph("Para2 Cerbung1", "Author 1.2"))
        ),
        Cerbungs("https://static.wikia.nocookie.net/sexypedia/images/1/1d/Reddwhite.jpg/revision/latest?cb=20210627025743",
            "The brilliant success of Redd White", "Redd White", 194, "20/4/2022",
            "Book about how Redd White easily overcome his struggle to build BLUE CORP.",
            listOf(CerbungParagraph("Para1 Cerbung2", "Author 2.1"),
                CerbungParagraph("Para2 Cerbung2", "Author 2.2"))
        ),
        Cerbungs("https://foto.kontan.co.id/rR1W7O-aQLEV0NnCMEXADmdfEOc=/640x360/smart/2022/11/15/686454468p.jpg",
            "Bocchi the Guitar Hero", "Edgeworth Von Karma", 46, "5/3/2021",
            "Ryan Kojima picks up his guitar and transform into Bocchi, The Guitar Hero!",
            listOf(CerbungParagraph("Para1 Cerbung3", "Author 3.1"),
                CerbungParagraph("Para2 Cerbung3", "Author 3.2"))
        ),
        Cerbungs("https://images04.military.com/sites/default/files/media/equipment/military-aircraft/mq-9-reaper/2014/02/mq-9-reaper_003.jpg",
            "Satria Naga Coco", "Rieno Barrack", 192, "4/7/2023",
            "Siapa sangka satria yang ini bukanlah sebuah khayalan.",
            listOf(CerbungParagraph("Para1 Cerbung4", "Author 4.1"),
                CerbungParagraph("Para2 Cerbung4", "Author 4.2"))
        ),
        Cerbungs("https://www.cultura.id/wp-content/uploads/2022/10/JoJos-Bizarre-Adventure-Season-4.jpg",
            "Dodo's Normal Adventure", "Hirahiki Aruku", 112, "10/10/2024",
            "Dodo and his Brother, Jio accidentally found a cheap plastic mask in Pasar Atom.",
            listOf(CerbungParagraph("Para1 Cerbung5", "Author 5.1"),
                CerbungParagraph("Para2 Cerbung5", "Author 5.2"))
        ),
    )

    val genre : Array<Genre> = arrayOf(
        Genre(1, "Action"),
        Genre(2, "Horror"),
        Genre(3, "Psychology"),
        Genre(4, "Romance"),
        Genre(5, "Thriller")
    )
}