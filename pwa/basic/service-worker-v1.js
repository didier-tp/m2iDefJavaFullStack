
var CACHE_NAME = 'my-site-cache-v1';
/*
var urlsToCache = [
'/css/styles.css',
'/js/main.js',
'/json/sampleData.json'
];*/
var urlsToCache = [
'/index.html',
'/manifest.json',
'/service-worker.js',
'/js/pendu.js',
'/sp_pendu.html'
]

self.addEventListener('install', function(event) {
console.log('[ServiceWorker] install');
// Perform install steps
event.waitUntil(
	caches.open(CACHE_NAME)
	.then(function(cache) {
	//console.log('Opened cache before addAll urlsToCache');
	return cache.addAll(urlsToCache);

	self.addEventListener('activate', function(event) {
		console.log('[ServiceWorker] activate', event);
	});
	})
);
});

self.addEventListener('fetch', function(event) {
event.respondWith(
caches.match(event.request)
.then(function(response) {
// Cache hit - return response
if (response) {
return response;
}
return fetch(event.request);
}
)
);
});
