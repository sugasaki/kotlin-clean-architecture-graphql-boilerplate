package usecase.model

import com.mapk.conversion.AbstractKConverter
import com.mapk.conversion.KConvertBy
import domain.entity.ValueStringClass
import kotlin.reflect.KClass

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@KConvertBy([IValueClassToString::class])
annotation class ValueStringClassConverter()

/**
 * IValueClass<String> -> String
 * @property srcClass KClass<ValueStringClass>
 * @constructor
 */
class IValueClassToString(
    annotation: ValueStringClassConverter
) : AbstractKConverter<ValueStringClassConverter, ValueStringClass, String>(annotation) {
    override val srcClass: KClass<ValueStringClass> = ValueStringClass::class
    override fun convert(source: ValueStringClass): String = source.value
}
