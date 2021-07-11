package com.example.androidtv.ui

import android.os.Bundle
import androidx.leanback.app.GuidedStepSupportFragment
import androidx.leanback.widget.*


class GuidedStepsFragment : GuidedStepSupportFragment() {
    override fun onCreateGuidance(savedInstanceState: Bundle?): GuidanceStylist.Guidance {
        return GuidanceStylist.Guidance(
            "Test d'une guidance liste ?",
            "Un test effectuer lors d'un TP...",
            "Question 1",
            null
        )
    }

    override fun onCreateActions(actions: MutableList<GuidedAction>, savedInstanceState: Bundle?) {



        val actionYes = GuidedAction.Builder(requireContext()).id(0).title("Oui").build()
        val actionNo = GuidedAction.Builder(requireContext()).id(1).title("Non").build()

        val actionMaybe = GuidedAction.Builder(requireContext()).id(3).title("Peut-être").build()
        val actionExact =
            GuidedAction.Builder(requireContext()).id(4).title("Exactement").build()

        val subActionsList = mutableListOf<GuidedAction>(actionMaybe, actionExact)

        val actionDoubt = GuidedAction.Builder(requireContext()).id(2).title("Pas sur")
            .description("Cliquez pour ouvrir").subActions(subActionsList).build()

        actions.add(actionYes)
        actions.add(actionNo)
        actions.add(actionDoubt)
    }

    override fun onSubGuidedActionClicked(action: GuidedAction?): Boolean {
        findActionById(2).description = action?.title ?: "missing response"

        val position = findActionPositionById(2)
        notifyActionChanged(position)

        return super.onSubGuidedActionClicked(action)
    }


}
