var bounds = ol.proj.transformExtent([126, 43, 128, 32], 'EPSG:4326', 'EPSG:3857');

var geojsonFormat = new ol.format.GeoJSON();

window.loadFeatures = function(response) {
	vectorSource.addFeatures(geojsonFormat.readFeatures(response));
};
var vectorSource = new ol.source.Vector({
	loader: function(extent, resolution, projection) {
		var url = 'http://localhost:8090/geoserver/LibWS/ows?service=WFS&'+
		'version=1.1.0&request=GetFeature&typename=LibWS:tbl_coor&'+
		'outputFormat=text/javascript&format_options=callback:loadFeatures'+
		'&srsname=EPSG:3857&bbox=' + extent.join(',') + ',EPSG:3857'		
		$.ajax({
			url: url,
			dataType: 'jsonp',
			jsonp: false
		});
	},
	strategy: ol.loadingstrategy.tile(ol.tilegrid.createXYZ({
		maxZoom: 19
	}))
});


var imagesourceWMS = new ol.source.ImageWMS({
	ratio: 1,
	url: 'http://localhost:8090/geoserver/LibWS/wms',
	params: {'FORMAT': 'image/png', LAYERS: 'LibWS:tbl_coor'}
});

var osmlayer = new ol.layer.Tile({
	source: new ol.source.OSM()
});

var pLibraryWFSlayer = new ol.layer.Vector({
	source: vectorSource
});


var untiled = new ol.layer.Image({
	source: imagesourceWMS
});

var map = new ol.Map({
	controls: ol.control.defaults({
		attribution: false
	}),
	target: 'map',
	layers: [osmlayer, pLibraryWFSlayer, untiled]
});

map.getView().fit(bounds, map.getSize());

map.on('singleclick', function(evt) {
	displayFeatureInfo(evt.pixel);
	
});
var displayFeatureInfo = function(pixel) {
	var feature = map.forEachFeatureAtPixel(pixel, function(feature, layer) {
		return feature;
	});
	
	if (feature) {
		FeatureInfoLoad(feature);
		
	} else {
		FeatureInfoWndClose();
	
	}
};

function setGIDList(selectgid){
	map.getLayers().item(2)
	var strCQL = "lib_id in("+selectgid+")";
	
	imagesourceWMS.updateParams({'CQL_FILTER': strCQL});
}

function setGIDList(selectgid){
	map.getLayers().item(3)
	var strCQL = "lib_id in("+selectgid+")";
	
	imagesourceWMS.updateParams({'CQL_FILTER': strCQL});
}
