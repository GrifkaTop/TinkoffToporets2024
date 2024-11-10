package com.example.myfirstapp

class PetShop {
    fun identify(animal: Animal): String {
        return when (animal) {
            is Dog -> "Dog"
            is Cat -> "Cat"
            else -> "Unknown"
        }
    }
}

interface Animal {
    val weight: Double
    val age: Int
}

interface Cat : Animal {
    val behaviorType: BehaviorType
}

interface Dog : Animal {
    val biteType: BiteType
}

enum class BiteType {
    DIRECT, OVERBITE, UNDERBITE
}

enum class BehaviorType {
    ACTIVE, PASSIVE
}

// Dog Breed
class Husky(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.DIRECT
}

class Corgi(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.UNDERBITE
}

// Cat Breed
class Siamese(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.ACTIVE
}

class Scottish(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.PASSIVE
}