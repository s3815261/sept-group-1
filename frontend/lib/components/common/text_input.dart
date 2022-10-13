import 'package:flutter/material.dart';
import 'package:frontend/common/theme.dart';

class TextInput extends StatefulWidget {
  final String labelText;
  final String hintText;
  final String initialValue;
  final Function? validation;
  final TextInputType keyboardType;
  final TextEditingController? controller;

  const TextInput(
      {
        super.key,
        this.labelText="",
        this.hintText="",
        this.initialValue="",
        this.keyboardType=TextInputType.text,
        this.validation,
        this.controller,
      });

  @override
  State<TextInput> createState() => _TextInputState(initialValue: initialValue, controller: controller);
}

class _TextInputState extends State<TextInput> {
  String initialValue;
  TextEditingController _controller = TextEditingController();

  _TextInputState({required this.initialValue, required TextEditingController? controller}) {
    if (controller!=null) {
      _controller =  controller;
    }

    _controller.text = initialValue.isEmpty ? "" : initialValue;
  }


  @override
  void dispose() {
    // Clean up the controller when the widget is disposed.
    _controller.dispose();
    super.dispose();
  }

  @override
  build(BuildContext context) {
    return Container(
      decoration: ThemeLite().inputBoxDecorationShadow(),
      child: TextFormField(
        decoration: ThemeLite().textInputDecoration(widget.labelText, widget.hintText),
        // initialValue: controller.text,
        keyboardType: widget.keyboardType,
        controller: _controller,
        validator: widget.validation==null ? null: widget.validation!(_controller.text),
      ),
    );
  }
}