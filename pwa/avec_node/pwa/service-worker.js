importScripts('../lib/workbox.3.6.1.js');


workbox.routing.registerRoute(
new RegExp('.*\.js'),
workbox.strategies.networkFirst()
);

workbox.precaching.precache([
  {
    url: '/index.html',
    revision: 'r1',
  }, 
  {
    url: '/lib/workbox.3.6.1.js',
    revision: 'r1',
  }
]);
workbox.precaching.addRoute();

workbox.routing.registerRoute(
new RegExp('.*\.html'),
workbox.strategies.cacheFirst()
);

workbox.routing.registerRoute(
new RegExp('/news/.*'),
workbox.strategies.networkFirst()
);

workbox.routing.registerRoute(
new RegExp('.*\.json'),
workbox.strategies.networkFirst()
);

workbox.routing.registerRoute(
// Cache CSS files
/.*\.css/,
// Use cache but update in the background ASAP
workbox.strategies.staleWhileRevalidate({
// Use a custom cache name
cacheName: 'css-cache',
})
);

workbox.routing.registerRoute(
// Cache image files
/.*\.(?:png|jpg|jpeg|svg|gif)/,
// Use the cache if it's available
workbox.strategies.cacheFirst({
// Use a custom cache name
cacheName: 'image-cache',
plugins: [
new workbox.expiration.Plugin({
// Cache only 200 images
maxEntries: 200,
// Cache for a maximum of a week
maxAgeSeconds: 7 * 24 * 60 * 60,
})
],
})
);

/*
self.addEventListener('install', function(event) {
console.log('[ServiceWorker] install ***');
});

self.addEventListener('activate', function(event) {
	console.log('[ServiceWorker] activate ***');
});

self.addEventListener('fetch', function(event) {
	console.log('[ServiceWorker] fetch ***');
});
*/