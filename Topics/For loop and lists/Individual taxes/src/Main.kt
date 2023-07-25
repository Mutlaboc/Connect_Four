fun main() {
    // write your code here
    val companies = readln().toInt()
    val companyList = mutableListOf<Int>()
    //var taxTotal = mutableListOf<Double>(companies.toDouble())
    repeat(companies*2){
        companyList.add(readln().toInt())
    }
    /*for (i in 0 until companies){
        val taxPercent = readln().toInt()
        var taxAbsol = (companyList[i].toDouble()/100)*taxPercent
        taxTotal.add(taxAbsol)
    }
    println(taxTotal.indexOf(taxTotal.max()))
    */

    var maxTaxCompIndx = 0
    var maxTaxComp = 0.00

    for (i in 0 until companies){
        var tax: Double = ((companyList[i].toDouble())*(companyList[i+companies].toDouble()*0.01))
       // println("Доход компании $i ${companyList[i]}" )
       // println("налог компании $i ${companyList[i+companies].toDouble()*0.01}" )
       // println("Налог компании $i $tax")
        if (tax>maxTaxComp){
            maxTaxComp = tax
            maxTaxCompIndx = i+1
        }

    }
    println(maxTaxCompIndx)


}