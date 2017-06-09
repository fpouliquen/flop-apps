import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SongAdminComponent }   from '../song-admin/song-admin.component';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'songadmin',  component: SongAdminComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
