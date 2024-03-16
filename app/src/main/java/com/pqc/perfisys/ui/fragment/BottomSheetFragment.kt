
import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pqc.perfisys.databinding.FragmentBottomSheetBinding
import com.pqc.perfisys.ui.adapter.CategoryAdapter
import com.pqc.perfisys.viewmodel.ImageViewModel

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private val imageViewModel: ImageViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize RecyclerView and Adapter
        categoryAdapter = CategoryAdapter(emptyList()) { _ ->

        }
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(),3)
            adapter = categoryAdapter
        }

        // Observe categories LiveData from the ViewModel
        imageViewModel.categoriesLiveData.observe(viewLifecycleOwner) { categories ->
            if (!categories.isNullOrEmpty()) {
                categoryAdapter.categories = categories
                categoryAdapter.notifyDataSetChanged()
            }
        }
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }
}
