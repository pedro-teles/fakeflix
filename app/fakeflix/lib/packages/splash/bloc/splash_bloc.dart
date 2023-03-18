import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:fakeflix/common/sdui/service/screen_service.dart';
import 'package:fakeflix/packages/splash/bloc/state/splash_state.dart';
import 'package:fakeflix/packages/splash/bloc/event/SplashEvent.dart';

class SplashBloc extends Bloc<SplashEvent, SplashState> {
  final ScreenService service = ScreenService();

  SplashBloc() : super(Loading()) {
    on<Load>((event, emit) async {
      final screenWidgets = await service.getUiComponents('api/screen/welcome');

      emit(Loaded(screenWidgets));
    });
  }

}
