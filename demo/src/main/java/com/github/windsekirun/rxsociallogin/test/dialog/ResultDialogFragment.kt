package com.github.windsekirun.rxsociallogin.test.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentActivity
import com.github.windsekirun.rxsociallogin.intenal.model.LoginResultItem
import com.github.windsekirun.rxsociallogin.test.R
import com.github.windsekirun.rxsociallogin.test.databinding.ResultDialogFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * RxSocialLogin
 * Class: ResultDialogFragment
 * Created by Pyxis on 2019-02-07.
 *
 * Description:
 */
class ResultDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: ResultDialogFragmentBinding
    val item = ObservableField<LoginResultItem>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.BottomSheetDialogThemeLight)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.result_dialog_fragment, container, false)
        binding.dialog = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun show(activity: FragmentActivity, item: LoginResultItem): ResultDialogFragment {
            val fragment = ResultDialogFragment().apply {
                this.item.set(item)
            }

            activity.supportFragmentManager.beginTransaction()
                    .add(fragment, "result-dialog").commit()

            return fragment
        }
    }
}