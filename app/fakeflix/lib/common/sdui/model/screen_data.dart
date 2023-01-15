class ServerDrivenWidget {
  ServerDrivenWidget();
}

class ScreenWidgets {
  ScreenWidgets(this.screen);

  final ScreenComponent screen;
}

class ScreenComponent {
  ScreenComponent(this.body);

  final List<ServerDrivenWidget> body;
}

class ButtonComponent extends ServerDrivenWidget {
  ButtonComponent(this.label, this.deeplink);

  final String label;
  final String? deeplink;
}

class PageViewComponent extends ServerDrivenWidget {
  PageViewComponent(this.pages);

  final List<PageComponent> pages;
}

class PageComponent {
  PageComponent(this.title, this.description);

  final String title;
  final String description;
}
