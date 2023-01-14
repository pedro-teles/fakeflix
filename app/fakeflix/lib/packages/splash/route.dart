import 'package:fakeflix/packages/splash/presentation/SplashScreen.dart';
import 'package:flutter/widgets.dart';
import 'package:nuvigator/next.dart';

class SplashRoute extends NuRoute {
  @override
  Widget build(BuildContext context, NuRouteSettings<Object> settings) {
    return const SplashScreen();
  }

  @override
  String get path => 'splash';

  @override
  ScreenType get screenType => materialScreenType;

}
