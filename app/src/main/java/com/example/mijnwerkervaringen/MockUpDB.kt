package com.example.mijnwerkervaringen

class MockUpDB {

    fun getGebruiker(): Gebruiker {

        return Gebruiker("Catherina", "Van Hauwermeiren", "08/01/1986", "Oudenaarde"
            , "TSO Boekhouden-Informatica")

    }

    fun getWerkervaringen() : List<Ervaring> {

        val werkErvaringen = arrayOf(
            Ervaring(1,"01/01/2022", "31/01/2022", "KBO Nederename", "opvang"),
            Ervaring(2,"01/01/2021", "31/01/2021", "KBO Ename", "opvang"),
            Ervaring(3,"01/01/2020", "31/01/2020", "KBO Volkegem", "opvang"),
            Ervaring(4,"01/01/2019", "31/01/2019", "KBO Mater", "opvang"),
            Ervaring(5,"01/01/2020", "31/01/2020", "KBO Volkegem", "opvang"),
            Ervaring(6,"01/01/2019", "31/01/2019", "KBO Mater", "opvang"))

        return werkErvaringen.toList()
    }
}