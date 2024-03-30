package mixin.bindings;

import com.gallichron.newagealexscaves.mixinkt.NuclearUtilMixinKt;
import net.minecraft.world.entity.LivingEntity;
import org.antarcticgardens.newage.content.reactor.NuclearUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = NuclearUtil.class, remap = false)
public class NuclearUtilMixin {

	@SuppressWarnings({"unused"})
	@Inject(at = @At("HEAD"), method = "irradiate", remap = false, cancellable = true)
	static private void irradiate(LivingEntity entity, CallbackInfo ci) {
		NuclearUtilMixinKt.nuclearUtilMixin(entity);
		ci.cancel();
	}
}