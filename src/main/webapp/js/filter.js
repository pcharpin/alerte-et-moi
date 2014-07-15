angular.module('filters', []).filter('booleanTooString', function() {
  return function(input) {
    return input == 0 ? 'non' : 'oui';
  };
});