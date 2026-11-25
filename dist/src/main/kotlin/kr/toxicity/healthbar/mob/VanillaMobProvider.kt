package kr.toxicity.healthbar.mob

import kr.toxicity.healthbar.api.mob.HealthBarMob
import kr.toxicity.healthbar.api.mob.MobConfiguration
import kr.toxicity.healthbar.api.mob.MobProvider
import kr.toxicity.healthbar.manager.MobManagerImpl
import org.bukkit.entity.LivingEntity

class VanillaMobProvider : MobProvider {
    override fun provide(entity: LivingEntity): HealthBarMob? {
        val configuration = MobManagerImpl.configuration(entity.type.name) ?: return null
        return object : HealthBarMob {
            override fun id(): String = entity.type.name
            override fun handle(): Any = entity
            override fun configuration(): MobConfiguration = configuration
        }
    }
}
