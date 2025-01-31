import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChannelService } from '../../services/channel.service';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent implements OnInit {
  channels: any[] = [];
  friends: any[] = [];

  constructor(private channelService: ChannelService) {}

  ngOnInit(): void {
    this.channelService.getChannels().subscribe(response => {
      this.channels = response; 
    });
    this.channelService.getFriends().subscribe(response => {
      this.friends = response;
    });
  }
  selectChannel(channelId: number) {
    console.log('Selected channel:', channelId);
  }
}
