import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ChannelService {
  private apiUrl = 'http://localhost:8118/channels';

  constructor(private http: HttpClient) {}

  getChannels(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  getFriends(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8118/friends');
  }
}
