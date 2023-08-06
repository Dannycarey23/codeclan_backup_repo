const assert = require('assert');
const PangramFinder = require('./pangram_finder.js');

describe('PangramFinder', function () {
  it('should be able to detect a pangram', function () {
    const pangramFinder = new PangramFinder('the quick brown fox jumps over the lazy dog');
    assert.strictEqual(pangramFinder.isPangram(), true);
  });

  it('should be able to detect a non-pangram', function () {
    const pangramFinder = new PangramFinder('this is not a pangram so the result should be false');
    assert.strictEqual(pangramFinder.isPangram(), false);
  });

  it('should be able to detect a pangram with mixed case', function () {
    const pangramFinder = new PangramFinder('The FIVE boxinG WiZaRdS JUMP quickly');
    assert.strictEqual(pangramFinder.isPangram(), true);
  });

  it('should be able to detect a non-pangram with mixed case', function () {
    const pangramFinder = new PangramFinder('AGaIn ThIs Is NOt a PanGram as It DOeS NoT COnTaIn aLL the LetTerS oF THE ALPhaBet');
    assert.strictEqual(pangramFinder.isPangram(), false);
  });

  it('should be able to detect a pangram with special characters', function () {
    const pangramFinder = new PangramFinder('how_vexingly_quick_daft_zebras_jump!');
    assert.strictEqual(pangramFinder.isPangram(), true);
  });

  it('should be able to detect a non-pangram with special characters', function () {
    const pangramFinder = new PangramFinder('look_just_clear_this_up:_is_this_a_pangram_or_not?!');
    assert.strictEqual(pangramFinder.isPangram(), false);
  });

  it('should be able to handle an empty string', function () {
    const pangramFinder = new PangramFinder('');
    assert.strictEqual(pangramFinder.isPangram(), false);
  });
});
