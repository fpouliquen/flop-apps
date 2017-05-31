import { SongManagerClientPage } from './app.po';

describe('song-manager-client App', () => {
  let page: SongManagerClientPage;

  beforeEach(() => {
    page = new SongManagerClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
