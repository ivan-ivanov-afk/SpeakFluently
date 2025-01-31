import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class MessageService {
  private apiUrl = 'http://localhost:8118/api/messages';

  constructor() {}

  async sendMessage(message: string): Promise<void> {
    try {
      await fetch(this.apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ content: message })
      });
    } catch (error) {
      console.error('Error sending message:', error);
    }
  }
}