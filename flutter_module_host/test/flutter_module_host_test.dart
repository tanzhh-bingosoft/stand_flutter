import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_module_host/flutter_module_host.dart';
import 'package:flutter_module_host/flutter_module_host_platform_interface.dart';
import 'package:flutter_module_host/flutter_module_host_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockFlutterModuleHostPlatform
    with MockPlatformInterfaceMixin
    implements FlutterModuleHostPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final FlutterModuleHostPlatform initialPlatform = FlutterModuleHostPlatform.instance;

  test('$MethodChannelFlutterModuleHost is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelFlutterModuleHost>());
  });

  test('getPlatformVersion', () async {
    FlutterModuleHost flutterModuleHostPlugin = FlutterModuleHost();
    MockFlutterModuleHostPlatform fakePlatform = MockFlutterModuleHostPlatform();
    FlutterModuleHostPlatform.instance = fakePlatform;

    expect(await flutterModuleHostPlugin.getPlatformVersion(), '42');
  });
}
