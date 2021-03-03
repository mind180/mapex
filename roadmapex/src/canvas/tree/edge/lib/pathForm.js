const curve = {
  BottomRight: (height, width, lineWidth) => {
    const padding = lineWidth * 0.5;

    return "M0 " + padding +
        "Q " + width / 3.5 + " 0 " +
        width / 2 + " " + height / 2 +
        " T " + width + " " + (height - padding);
  },

  BottomLeft: (height, width, lineWidth) => {
    const padding = lineWidth * 0.5;

    return "M" + (width - padding) + " " + padding +
        "Q " + width / 1.5 + " 0 " +
        width / 2 + " " + height / 2 +
        " T " + padding + " " + (height - padding);
  },

  TopRight: (height, width, lineWidth) => {
    const padding = lineWidth * 0.5;

    return "M" + padding + " " + (height - padding) + " " +
        "Q " + width / 3.5 + " " + height + " " +
        width / 2 + " " + height / 2 +
        " T " + (width - padding) + " " + padding;
  },

  TopLeft: (height, width, lineWidth) => {
    const padding = lineWidth * 0.5;

    return "M" + padding + " " + padding +
        "Q " + width / 3.5 + " 0 " +
        width / 2 + " " + height / 2 +
        " T " + (width - padding) + " " + (height - padding);
  }
};

const straight = {
  BottomRight: (height, width, lineWidth) => {
    const padding = 0.5 * lineWidth;

    return "M" + padding + " " + padding +
        " L" + (width - padding) +  " " + (height - padding);
  },

  BottomLeft: (height, width, lineWidth) => {
    const padding = 0.5 * lineWidth;

    return "M" + (width - padding) + " " + padding +
        " L" + padding + " " + (height - padding);
  },

  TopRight: (height, width, lineWidth) => {
    const padding = 0.5 * lineWidth;

    return "M" + (width - padding) + " " + padding +
        " L" + padding + " " + (height - padding);
  },

  TopLeft: (height, width, lineWidth) => {
    const padding = 0.5 * lineWidth;

    return "M" + (width - padding) + " " + (height - padding) +
        " L" + padding + " " + padding;
  },
};

export const pathForm = {
  curve,
  straight
};