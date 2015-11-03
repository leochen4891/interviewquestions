class ITNode<T extends Comparable<T>> {
	public T low;
	public T high;
	public T max;

	public ITNode<T> left;
	public ITNode<T> right;

	public ITNode(T low, T high, T max) {
		this.low = low;
		this.high = high;
		this.max = max;
	}

	public boolean intersects(T low, T high) {
		return (this.high.compareTo(low) >= 0 && this.low.compareTo(high) <= 0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("[").append(low).append(", ").append(high).append("]").toString();
	}
}