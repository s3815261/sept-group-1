import 'package:frontend/components/chat/chat_message_model.dart';
import 'package:frontend/screens/ChatWidget.dart';
import 'package:flutter/material.dart';
import 'package:frontend/common/flow_theme.dart';

class ChatBubble extends StatefulWidget {
  ChatMessage chatMessage;
  ChatBubble({super.key, required this.chatMessage});
  @override
  _ChatBubbleState createState() => _ChatBubbleState();
}

class _ChatBubbleState extends State<ChatBubble> {
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(
          left: widget.chatMessage.type == MessageType.Receiver ? 15 : 100,
          right: widget.chatMessage.type == MessageType.Receiver ? 100 : 15,
          top: 7.5,
          bottom: 7.5
      ),

      child: Align(
        alignment: (widget.chatMessage.type == MessageType.Receiver
            ? Alignment.topLeft
            : Alignment.topRight),
        child: Container(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(15),
            color: (widget.chatMessage.type == MessageType.Receiver
                ? Colors.white
                : FlowTheme.of(context).primaryColor),
          ),
          padding: const EdgeInsets.only(
            left: 15,
            right: 15,
            top: 10,
            bottom: 10
          ),
          child: Text(
            widget.chatMessage.message,
            style: TextStyle(
              color: (widget.chatMessage.type == MessageType.Receiver
                  ? FlowTheme.of(context).primaryText
                  : FlowTheme.of(context).alternate),
            ),
          ),
        ),
      ),
    );
  }
}
