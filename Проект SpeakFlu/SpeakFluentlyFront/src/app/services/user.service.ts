import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class UserService {
  private apiUrl = 'http://localhost:8118/api/users';

  constructor() {}

  async getUsers(): Promise<string[]> {
    try {
      const response = await fetch(this.apiUrl);
      return response.ok ? await response.json() : [];
    } catch (error) {
      console.error('Error fetching users:', error);
      return [];
    }
  }
}