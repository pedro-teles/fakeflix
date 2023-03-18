import 'package:flutter/widgets.dart';
import 'package:nuvigator/next.dart';

import 'controller/splash_controller.dart';

class SplashRoute extends NuRoute {
  @override
  Widget build(BuildContext context, NuRouteSettings<Object> settings) {
    return SplashController();
  }

  @override
  String get path => 'splash';

  @override
  ScreenType get screenType => materialScreenType;

}
