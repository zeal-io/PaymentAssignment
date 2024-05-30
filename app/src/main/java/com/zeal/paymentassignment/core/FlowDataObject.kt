package com.zeal.paymentassignment.core


class FlowDataObject {
    companion object {
        var _instance: FlowDataObject? = null
        var block = Unit
        fun getInstance() = _instance ?: synchronized(block) {
            return _instance ?: FlowDataObject().also { _instance = it; }
        }

        fun getNewInstance() = FlowDataObject().also { _instance = it; }
    }


    var entryMode: EntryMode = EntryMode.Emv
    var flowType: FlowType = FlowType.SALE
    var amount: Float = 0f;
    var pan: String? = null;
    var expire: String? = null;
    var aid: String? = null;
    var merchantCopy: Boolean = true;
    var doneZeal: Boolean = false;
}

enum class FlowType {
    SALE, REFUND, ZealRedemption
}

enum class EntryMode {
    Manual, Emv
}