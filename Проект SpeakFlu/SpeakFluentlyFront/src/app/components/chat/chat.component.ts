import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChatService } from '../../services/chat.service';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent implements OnInit {
  messages: any[] = [];
  newMessage: string = '';
  selectedChannelId: number | null = null;

  constructor(private chatService: ChatService) {}

  ngOnInit(): void {}

  loadMessages() {
    if (this.selectedChannelId) {
      this.chatService.getMessages(this.selectedChannelId).subscribe(response => {
        this.messages = response; 
      });
    }
  }

  sendMessage() {
    if (this.newMessage.trim() && this.selectedChannelId) {
      this.chatService.sendMessage(this.selectedChannelId, this.newMessage).subscribe(() => {
        this.messages.push({ text: this.newMessage, timestamp: new Date() });
        this.newMessage = '';
      });
    }
  }

  deleteMessage(messageId: number) {
    this.chatService.deleteMessage(messageId).subscribe(() => {
      this.messages = this.messages.filter(msg => msg.id !== messageId);
    });
  }
}
