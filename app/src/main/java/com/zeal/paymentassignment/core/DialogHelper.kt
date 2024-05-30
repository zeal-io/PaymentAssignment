package com.zeal.paymentassignment.core

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.zeal.paymentassignment.R
import com.zeal.paymentassignment.databinding.LoadingDialog2Binding
import java.util.function.Consumer

object DialogHelper {

    var loadingDialog: Dialog? = null;

    fun showPanDialog(context: Context, onDone: Consumer<String>, onClose: Runnable) =
        context.apply {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.card_number_dialog, null)
            val editTextCardId = dialogView.findViewById<EditText>(R.id.editTextCardId)
            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("Enter Amount and Card ID")
                .setPositiveButton("Submit") { dialog, _ ->
                    val cardId = editTextCardId.text.toString()
                    if (cardId.isNotEmpty()) {
                        onDone.accept(cardId)
                        dialog.dismiss()
                    } else {
                        Toast.makeText(this, "Please enter valid inputs", Toast.LENGTH_LONG).show();
                    }
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    onClose.run()
                    dialog.dismiss()
                }
            dialogBuilder.show()
        }

    fun showLoadingDialog(activity: Activity, title: String) {
        activity.runOnUiThread {
            val dialogView = LoadingDialog2Binding.inflate(LayoutInflater.from(activity))
            dialogView.tvContent.text = title;
            val dialogBuilder = AlertDialog.Builder(activity)
                .setView(dialogView.root)
                .setTitle("Loading")

            loadingDialog?.dismiss();
            loadingDialog = dialogBuilder.show()

        }


    }

    fun hideLoading(activity: Activity) {
        activity.runOnUiThread {
            loadingDialog?.hide()
        }
    }


}