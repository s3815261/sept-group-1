import 'package:flutter/material.dart';

class ProfileRounded extends StatelessWidget {
  final String imageUrl;
  final double margin;

  const ProfileRounded({super.key, required this.imageUrl, this.margin = -1});

  @override
  build(BuildContext context) {

    double imageSize = MediaQuery.of(context).size.width * 0.225 > 80 ? MediaQuery.of(context).size.width * 0.225 > 200 ? 200: MediaQuery.of(context).size.width * 0.225 : 80;

    return Container(
        width: imageSize,
        height: imageSize,
        margin: margin == -1 ? EdgeInsets.fromLTRB(0, imageSize * 0.5, 0,  imageSize * 0.15) : EdgeInsets.all(margin),
        decoration: BoxDecoration(
            shape: BoxShape.circle,
            image: DecorationImage(
                fit: BoxFit.fill,
                image: NetworkImage(imageUrl)
            )
        )
    );
  }
}
