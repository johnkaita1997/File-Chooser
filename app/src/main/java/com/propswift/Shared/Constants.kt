package com.propswift.Shared

import dmax.dialog.SpotsDialog

object Constants {

    var gender = ""
    lateinit var mydialog: SpotsDialog

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //              PAGINATION START
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var appVersionLocal = 2.3
    var loaded = false
    const val permission_request = 100
    const val ONESIGNAL_APP_ID = "52a2c790-173c-4606-a0a6-941f3b4d58eb"
    var alist = mutableListOf<String>()
    public lateinit var progressDialog: SpotsDialog

    //var baseurl = "https://rickandmortyapi.com"
    //var baseurl = "https://tafa.co.ke"
    //var baseurl = "http://192.168.50.69:8090"
    var baseurl = "http://192.168.100.4:8000"

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //              PAYPAL START
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //    val clientKey = "ARx3ElFHpFsAQibnzRpviaL63QZ4pmPzU1bUi3o1L6BvIPwtn0SU-CvtnODTSKWL9ecAVy1HKzJoMdEb"
    //    var apisecret = "Apisecret MPv32VRtyY5lpuT7VFTWNQxLhstDB7XoA5nEMjB501XpZlSjSFx5iYHiij8bnmOr"
    var apisecret = "Apisecret NJwFd5PDhAbL7Zfpql3lznfyOTLGdl7ulErPwMtCn3vWqQvGhP90YR0D4IjGskgP"


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //              MPESA START
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val busienessshortcode = "4083027"
    val thepasskey = "9cd4dd3777a83ffc18c70766a77e1f2077dbaea17188f98235158ed533f3331d"
    const val mpesa_callback_url = "http://192.168.43.105:0000"

    operator fun <T> List<T>.component6() = this[5]
    operator fun <T> List<T>.component7() = this[6]
    operator fun <T> List<T>.component8() = this[7]
    operator fun <T> List<T>.component9() = this[8]

    init {
    }


}