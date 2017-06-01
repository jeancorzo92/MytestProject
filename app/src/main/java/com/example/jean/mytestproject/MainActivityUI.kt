package com.example.jean.mytestproject

import android.text.InputType
import android.view.View
import org.jetbrains.anko.*


class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) : View = with(ui) {
        relativeLayout {
            editText {
                id = R.id.editText
                setText(R.string.name_placeholder)
                inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            }.lparams {
                width = matchParent
                margin = 8
                alignParentTop()
            }

            editText {
                id = R.id.editText2
                inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }.lparams {
                width = matchParent
                margin = 8
                below(R.id.editText)
            }

            button {
                id = R.id.button
                textResource = R.string.button_text
                setOnClickListener {
                    toast("you clicked the button!!!")
                }
            }.lparams {
                width = matchParent
                margin = 8
                below(R.id.editText2)
            }
        }
    }

}