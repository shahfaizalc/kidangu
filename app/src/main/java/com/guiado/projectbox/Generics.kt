package com.guiado.projectbox

import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.ArrayList


fun getTopics() = listOf("ஆன்மீகம்","வரலாறு","சினிமா","அரசியல்","பொருளாதாரம்","விளையாட்டு","அறிவியல்","கலை & கலாச்சாரம்")
fun getTopicsEng() = listOf("religion","history","cinema","politics","economy","sports","science","art")
fun getTopicsIcons() = listOf(R.drawable.oonee,R.drawable.two,R.drawable.three, R.drawable.four,R.drawable.five,R.drawable.sixx,R.drawable.seven,R.drawable.eight)


fun String.sentenceToWords(): List<String> {
    val list1 = ArrayList<String>()
    val p: Pattern = Pattern.compile("[a-zA-Z]+")

    val m1: Matcher = p.matcher(this.toLowerCase(Locale.getDefault()))

    while (m1.find()) {

        list1.add(m1.group());
    }
    return list1.toSet().toList();
}