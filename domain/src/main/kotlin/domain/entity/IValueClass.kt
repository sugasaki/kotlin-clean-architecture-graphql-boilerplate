package domain.entity

interface IValueClass<T : Any> {
    val value: T
}

interface ValueStringClass : IValueClass<String>
