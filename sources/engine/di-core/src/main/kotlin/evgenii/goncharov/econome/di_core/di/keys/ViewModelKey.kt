package evgenii.goncharov.econome.di_core.di.keys

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention
@MapKey
public annotation class ViewModelKey(val value: KClass<out ViewModel>)