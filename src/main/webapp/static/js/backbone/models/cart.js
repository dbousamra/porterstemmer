// A container for a tweet object.
var Tweet = Backbone.Model.extend({});

// A basic view rendering a single tweet
var TweetView = Backbone.View.extend({
    tagName: "li",
    className: "tweet",

    render: function() {

        // just render the tweet text as the content of this element.
        $(this.el).html(this.model.get("text"));
        return this;
    }
});

// A collection holding many tweet objects.
// also responsible for performing the
// search that fetches them.
var Tweets = Backbone.Collection.extend({
    model: Tweet,
    initialize: function(models, options) {
        this.query = options.query;
    },
    url: function() {
        return "http://search.twitter.com/search.json?q=" + this.query + "&callback=?";
    },
    parse: function(data) {

        // note that the original result contains tweets inside of a results array, not at 
        // the root of the response.
        return data.results;
    }
});

// A rendering of a collection of tweets.
var TweetsView = Backbone.View.extend({
    tagName: "ul",
    className: "tweets",
    render: function() {

        // for each tweet, create a view and prepend it to the list.
        this.collection.each(function(tweet) {
            var tweetView = new TweetView({
                model: tweet
            });
            $(this.el).prepend(tweetView.render().el);
        }, this);

        return this;
    }
});

// Create a new cat tweet collection
var catTweets = new Tweets([], {
    query: "cats"
});

// create a view that will contain our tweets
var catTweetsView = new TweetsView({
    collection: catTweets
});

// on a successful fetch, update the collection.
catTweets.fetch({
    success: function(collection) {
    	  $("#game").append(catTweetsView.render().el);
    }
})