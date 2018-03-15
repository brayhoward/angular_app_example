describe('progress bar with value below range', () => {
  it('does not fill the progress bar', () => {
    const progressBar = fixture('ValueBelowRange');
    const fill = Polymer.dom(progressBar.root).querySelector('#fill');
    expect(fill.style.transform).to.equal('scaleX(0)');
  });
});

describe('progress bar with value in range', () => {
  it('fills some of the progress bar', () => {
    const progressBar = fixture('ValueInRange');
    const fill = Polymer.dom(progressBar.root).querySelector('#fill');
    expect(fill.style.transform).to.equal('scaleX(0.8)');
  });
});

describe('progress bar with infinite value', () => {
  it('fills the entire progress bar during the animation', () => {
    const progressBar = fixture('ValueInfinite');
    const fill = Polymer.dom(progressBar.root).querySelector('#fill');
    const state = window.getComputedStyle(fill).getPropertyValue("animation-play-state");
    const name = window.getComputedStyle(fill).getPropertyValue("animation-name").split('-')[0];

    expect(name).to.equal('progress');
    expect(state).to.equal('running');
  });
});

describe('progress bar with custom min and max', () => {
  it('calculates the right ratio based on the min, max, and value', () => {
    const progressBar = fixture('CustomMinMax');
    const ratio = progressBar._ratio.toFixed(2);
    expect(ratio).to.equal('0.79');
  });
});
