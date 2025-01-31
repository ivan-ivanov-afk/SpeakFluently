import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private apiUrl = 'http://localhost:8118/channels  ';

  constructor(private http: HttpClient) {}

  getChannels(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/channels`);
  }

  getMessages(channelId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/channels/${channelId}/messages`);
  }

  sendMessage(channelId: number, message: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/channels/${channelId}/messages`, { text: message });
  }

  deleteMessage(messageId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/messages/${messageId}`);
  }
}