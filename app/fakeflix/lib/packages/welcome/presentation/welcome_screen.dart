import 'package:fakeflix/design/design.dart';
import 'package:flutter/widgets.dart' hide Page;

class WelcomeScreen extends StatelessWidget {
  const WelcomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Screen(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          Flexible(
            child: PageView(
              controller: PageController(),
              children: const [
                Page(
                  title: 'Filmes, séries e muito mais, sem limites',
                  description: 'Assista onde quiser. Cancele quando quiser.',
                ),
                Page(
                  title: 'Sem compromisso',
                  description: 'Assine hoje, cancele quando quiser.',
                ),
                Page(
                  title: 'Assista onde quiser',
                  description:
                      'Assista no celular, tablet, laptop, TV ou outros aparelhos.',
                ),
                Page(
                  title: 'Baixe e assista offline',
                  description:
                      'Disponível em todos os planos, exceto no Básico com anúncios.',
                )
              ],
            ),
          ),
          const Button(label: 'VAMOS LÁ'),
        ],
      ),
    );
  }
}
