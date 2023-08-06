const assert = require('assert');

// assert.equal(true, true);
// assert.equal(true, false);
// assert.equal(1, '1');
// assert.equal([], ![]);

// assert.strictEqual(1, '1');
// assert.strictEqual([1, 2, 3], [1, 2, 3]);

// const firstArray = [1, 2, 3];
// const secondArray = firstArray;
// assert.equal(firstArray, secondArray);

// assert.deepEqual([1, 2, 3], [1, 2, 3]);
// assert.deepEqual([1, 2, 3], ['1', '2', '3']);
assert.deepStrictEqual([1, 2, 3], ['1', '2', '3']);
