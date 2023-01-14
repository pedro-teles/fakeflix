import 'package:fakeflix/packages/splash/route.dart';
import 'package:nuvigator/next.dart';

class FakeflixRouter extends NuRouter {
  @override
  String get initialRoute => 'splash';

  @override
  List<NuRoute<NuRouter, Object, Object>> get registerRoutes => [
    SplashRoute()
  ];

}
