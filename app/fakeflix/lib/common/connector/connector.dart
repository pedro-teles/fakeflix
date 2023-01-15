import 'package:http/http.dart' as http;

class Connector {
  final String baseUrl = "192.168.15.47:5000";
  final httpClient = http.Client();
}
