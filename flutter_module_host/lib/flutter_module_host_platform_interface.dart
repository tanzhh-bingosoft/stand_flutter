import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'flutter_module_host_method_channel.dart';

abstract class FlutterModuleHostPlatform extends PlatformInterface {
  /// Constructs a FlutterModuleHostPlatform.
  FlutterModuleHostPlatform() : super(token: _token);

  static final Object _token = Object();

  static FlutterModuleHostPlatform _instance = MethodChannelFlutterModuleHost();

  /// The default instance of [FlutterModuleHostPlatform] to use.
  ///
  /// Defaults to [MethodChannelFlutterModuleHost].
  static FlutterModuleHostPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [FlutterModuleHostPlatform] when
  /// they register themselves.
  static set instance(FlutterModuleHostPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
