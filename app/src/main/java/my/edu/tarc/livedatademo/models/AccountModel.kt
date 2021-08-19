package my.edu.tarc.livedatademo.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    var accNo : String = ""
    var owner : String = ""
     // var balance: Double = 0.0

    // MutableLiveData allow data to be change
    private var _balance = MutableLiveData<Double>()
    val balance : LiveData<Double>
    get() = _balance // return data(balance) in the get method , allow get and view only

    init {
        this.accNo = accNo
        this.owner = owner
        this._balance.value = balance
    }

    fun deposit(amount: Double) {

        _balance.value = (_balance.value)?.plus(amount)
    }

    fun witdraw(amount:Double){
        _balance.value = (_balance.value)?.minus(amount)
    }

}