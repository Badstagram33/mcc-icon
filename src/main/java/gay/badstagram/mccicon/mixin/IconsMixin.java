package gay.badstagram.mccicon.mixin;

import gay.badstagram.mccicon.client.MCCIconClient;
import net.minecraft.client.util.Icons;
import net.minecraft.resource.InputSupplier;
import net.minecraft.resource.ResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.InputStream;

@Mixin(Icons.class)
public class IconsMixin {
    @Inject(method = "getIcon", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void returnBetterFile(ResourcePack resourcePack, String fileName, CallbackInfoReturnable<InputSupplier<InputStream>> cir) {
        MCCIconClient client = MCCIconClient.getInstance();

        cir.setReturnValue(() -> client.getIconStorage().getResource(fileName));
    }
}
