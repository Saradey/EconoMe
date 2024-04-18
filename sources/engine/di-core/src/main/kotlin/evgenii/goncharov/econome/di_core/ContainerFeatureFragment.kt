package evgenii.goncharov.econome.di_core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

public abstract class ContainerFeatureFragment : Fragment {

    public constructor(@LayoutRes layoutId: Int) : super(layoutId)
    public constructor() : super(R.layout.fragment_feature_container)
}