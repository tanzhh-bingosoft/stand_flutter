
import 'flutter_module_host_platform_interface.dart';

class FlutterModuleHost {
  Future<String?> getPlatformVersion() {
    return FlutterModuleHostPlatform.instance.getPlatformVersion();
  }
}
